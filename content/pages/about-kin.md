---
title: What is Kin?
date: Last Modified
permalink: /what-is-kin/index.html
eleventyNavigation:
  key: What is Kin
  order: 1
  title: What is Kin?
---

## Introduction
Simply put, Kin is money for the digital world, and it provides a way for developers (like you) to monetize their apps and websites in a fundamentally new way.

Kin’s vision is to create an ecosystem of apps where value is exchanged in Kin. Value is anything that is meaningful to a user. For example, a user liking a post could tip an amount of Kin as appreciation.

## Example Use-cases
|Premium content |Tipping     |Game currency  |
|----------|---------------|-------|
|<img width="508" src="https://lh5.googleusercontent.com/1_sJjnZVTT8EJVb_MTcY2mHR3FsZO6bI1bDx4Kl_a4iGFXihWNMFQawQfT0ddNRutMZ9LY8-S8hOO3Maotk72ghEVHfVQbNFNdr0ySIRT-80MkR9OGxhezuXSb4smlzo4LRcTKtD"> |  <img width="508" src="https://lh3.googleusercontent.com/fZRzvvvjk1xrt3pkZaA7uFPc-V5Rsswe1JivHfalPhSJMnhN-RVJCPqMdL4BVheMhc0tBE2AEs1wIg0t8dabqpD9SnpbkeOuL-TszrF9TglgHm9B0p1ST19gMFJI2WOE4XL3II7s"> | <img width="508" src="https://lh6.googleusercontent.com/0a7z5BDhhrPLibS1b3LU3i26eb_wEJGX-psIGAVVj1Q_yW1fWxfB1lSCoJ96_7FJw9EIJ2WkCLxekY250lko4MYvLGmmDrJ6IjvUelzwH_W4Mnu6-H8rnQKG2YI0f5c4TILJsTho"> |
|Users create exclusive groups require an entrance fee |Users tip each other for content that they like|Users earn/ buy Kin and use it to buy loot in a game.|

> There is no limit to what you can do with Kin as a developer.

![](https://lh4.googleusercontent.com/tLI12K6_jvIMorJndaquxhNHC7be-jes1TXs4YcVDukdE_c7R2XKYU2N4_DITnU4h2Lw71pLvpb-i0FA5k3kc2XbJLd4udoru8Tbg2v-LWOJpyfDHpkuywrLWfxsvAVCSNn16J0s)

## Can my app monetize with Kin?

Kin is free to integrate into any app that follows these [guidelines](https://github.com/kinecosystem/rewards-engine/blob/master/current-valid-spend-guidelines.md). Kin currently supports the following SDKs.

### Client side
-   [Android native](https://github.com/kinecosystem/kin-android)
-   [iOs native](https://github.com/kinecosystem/kin-ios/tree/master/KinBase)
-   [Web (beta)](https://kintegrate.dev/tutorials/getting-started-web-sdk/)
-   Unity (coming soon) 
-  Flutter (coming soon)
-  React Native (coming soon)
    
### Server side
-   [Python](https://github.com/kinecosystem/kin-sdk-python)
-   [Go](https://github.com/kinecosystem/kin-go)
-   [NodeJs](https://github.com/kinecosystem/kin-node)
  
## How do the Kin SDKs work?
Currencies have been in games and apps for decades. They let your users

1.  Earn (Receive currency)
2.  Spend (Send currency)

<img src="https://miro.medium.com/max/1000/0*K5DCY0vvs9SWFMDd.gif">
    
At the heart of it all, this is what your users will be doing in your app. The difference between a regular in-app currency and Kin is that Kin is a currency with actual value. The SDKs connect your app to Kin’s blockchain and handle all the [complicated business in the middle](https://docs.kin.org/kin-architecture-overview), so all you have to think about is:

1.  Sending Kin
2.  Receiving Kin

  
Client side SDKs let your users create accounts and send Kin to each other, or to your server.

*Kotlin sample - creating an account on an Android device*
```kotlin
private  fun  createAccount(): String {
  val kinContext = KinAccountContext.Builder(environment)
    .createNewAccount()
    .build()
    
  return kinContext.accountId.stellarBase32Encode()
}
```

Server side SDKs let you send Kin to your users as a reward for any action they take.

*NodeJs sample - sending Kin from the server to a user (TypeScript)*
```typescript
async submitPayment(
  sender: PrivateKey,
  destination: PublicKey,
  amount: string,
  type: TransactionType,
  memo?: string,
) {
  return this.client.submitPayment({
    sender,
    destination,
    type,
    memo,
    quarks: kinToQuarks(amount),
  });
}
```

Using Kin is as simple as:
1.  Deciding on a use case for your app
2.  Integrating an SDK

## How do I get started?
The following resources will help you add Kin to your app.

1.  [Kintegrate](/) is a developer maintained site that helps you quickly integrate Kin into your apps. We recommend [starting here](/tutorials/getting-started/) to get a broad understanding of integration.
    
2.  [Kin’s official documentation](https://docs.kin.org/intro) deep dives into client and server architecture, with more detailed concepts covered
    
3.  Join our [Developer Discord](https://discord.gg/urqVCnNy4G) for live tech support on any issues you are stuck in

## Apply for a Jumpstart Grant

Apps new to the ecosystem can apply for a grant in Kin, to help them get started and integrate into the ecosystem. The size of the grant is proportional to the size of the app joining. To learn more, send us a note detailing your application - requesting a [Jumpstart Grant](https://kin.org/catalyst-fund/).