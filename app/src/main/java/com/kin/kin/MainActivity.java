package com.kin.kin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.kin.sdk.base.models.KinBalance;
import org.kin.sdk.base.models.KinBinaryMemo;
import org.kin.sdk.base.models.KinPayment;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Initialize Kin*/
        Kin kin = new Kin(
                this.getApplicationContext(),
                false,
                165,
                "GC6D6TCMFYRTQEECH4FPAS2DFUECCF3KTCXOIYE4NEX2NIDAKQNJ32XS",
                "MyUser",
                "MyPass",
                ((Function1<KinBalance, Unit>) kinBalance -> {
                    balanceChanged(kinBalance);
                    return null;
                }),
                ((Function1<List<? extends KinPayment>, Unit>) payments -> {
                    paymentHappened(payments);
                    return null;
                }));

        /*Show the device's address to receive payments*/
        ((TextView) this.findViewById(R.id.address))
                .setText((CharSequence) ("Address: " + kin.address())); //Device's address to receive payments


        /*Send out a payment*/
        Button btnSendKin = this.findViewById(R.id.sendKin);
        btnSendKin.setOnClickListener((View.OnClickListener) ((View.OnClickListener) it -> {

            ((TextView) findViewById(R.id.messages))
                    .setText((CharSequence) " Sending Kin");

            //create a list to hold items being paid for
            List<Pair<String, Double>> paymentItems = new ArrayList<>();
            paymentItems.add(new Pair<>("One Hamburger", 2.0D));
            paymentItems.add(new Pair<>("Tip the waitress", 0.5D));

            /*Send a single transaction containing the payment items*/
            kin.sendKin(
                    paymentItems,
                    "C2Tb36xUjDDiN4H3xE2T7PuBFb1gdCvP7znen1m8FStJ",
                    KinBinaryMemo.TransferType.Spend.INSTANCE,
                    (kinPayment, throwable) -> {
                        sentKin(kinPayment, throwable);
                        return null;
                    });
        }));

        /*The balance and payment listeners activate whenever this app sends Kin
         * However, you can periodically force them to check for transactions that happened
         * I.e. someone sent it Kin
         **/
        Button btnRefreshBalance = this.findViewById(R.id.refresh);
        btnRefreshBalance.setOnClickListener((View.OnClickListener) ((View.OnClickListener) it -> {
            //NOTE: THERE IS A LAG BETWEEN RECEIVING A TRANSACTION AND THE LISTENERS DETECTING IT. (seconds to minutes)
            //Calling this too soon will give you THE WRONG BALANCE
            //So check approx 60 seconds after expecting a transaction
            //If you send a payment and force refresh too soon, you will get 'old' balance information
            kin.checkTransactions();
            ((TextView) findViewById(R.id.messages)).setText((CharSequence) "Balance refreshed");
        }));

    }

    private void balanceChanged(KinBalance balance) {
        //Use this to update your user's current balance
        ((TextView) this.findViewById(R.id.balance))
                .setText((CharSequence) ("Balance:" + balance.getAmount().toString() + " Kin"));
    }

    private void paymentHappened(List<? extends KinPayment> payments) {
        //Use this to know when a payment has taken place
        String timeStr = new Date(new Timestamp(((KinPayment) CollectionsKt.first(payments)).getTimestamp()).getTime()).toString();
        ((TextView) this.findViewById(R.id.payments))
                .setText((CharSequence) ("Last Payment: " + timeStr));
    }

    private void sentKin(KinPayment payment, Throwable error) {
        //Use this to know when the payment is sent
        TextView messagesTV = this.findViewById(R.id.messages);
        if (error == null) {
            messagesTV.setText((CharSequence) "Sent Kin");
        } else {
            messagesTV.setText((CharSequence) "Error sending Kin");
        }
    }
}