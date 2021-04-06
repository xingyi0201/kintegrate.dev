---
title: Getting Started with the Node SDK
date: Last Modified
permalink: tutorials/getting-started-node-sdk/index.html
eleventyNavigation:
  key: TutorialsGettingStartedNodeSdk
  order: 24
  parent: TutorialsGettingStarted
  title: Node
---

## Introduction

This tutorial will take you through the basics of creating a Kin enabled app using Node.js.

## Requirements

Make sure you have read [Getting Started](/tutorials/getting-started/) and have the required environment variables

## Implementing Kin in your app

#### 1. Install the Kin SDK for Node to your project:

```shell
npm install @kinecosystem/kin-sdk-v2
# Or if you use yarn
yarn add @kinecosystem/kin-sdk-v2
```

#### 2. Create a Node.js app and add the [kin.ts](https://github.com/kintegrate/kin-starter-node/blob/main/src/kin.ts) class to your app

This class abstracts some calls to Kin's official SDK and is fully usable out of the box. However, you can easily extend it to suite your custom needs.

#### 3. Instantiate a new Kin client

We're creating a new instance of our Kin wrapper and pass in the environment. In this example we'll pick the Test network.

```typescript
// Set up Kin client
const kin = new Kin(Environment.Test)
```

### Congratulations! You now have a Kin enabled app running!

## Making calls to the Kin blockchain

In this example, we're going to create a new wallet for both Alice and Bob by generating new key pair. After the wallet is created, Alice will send a P2P transaction to Bob.

#### 4. Create account for Alice

We create a new private key-pair for Alice, then call into our wrapper to create a new account. After creation, we log out the public address of both the wallet, and the token accounts

```typescript
const privateKeyAlice = Kin.generateKey()
const tokenAccountsAlice = await kin.createAccount(privateKeyAlice)

console.log(`Public Key Alice    ${privateKeyAlice.publicKey().toBase58()}`)
for (const tokenAccount of tokenAccountsAlice) {
  console.log(`Token Account Alice ${tokenAccount.toBase58()}`)
}
```

#### 4. Create account for Bob

```typescript
const privateKeyBob = Kin.generateKey()
const tokenAccountsBob = await kin.createAccount(privateKeyBob)

console.log(`Public Key Bob      ${privateKeyBob.publicKey().toBase58()}`)
for (const tokenAccount of tokenAccountsBob) {
  console.log(`Token Account Bob   ${tokenAccount.toBase58()}`)
}
```

#### 5. Add Helper method

Creating the Account on the Solana Blockchain and later the Kin token account, might take a few seconds. To address for this, we will have several 15 seconds sleep periods as it's an easy way to delay things in our code.

We also use this helper method to print the balance after sleeping.

```typescript
// Helper method to await sleep...
const sleep = (seconds = 1) => new Promise((resolve) => setTimeout(resolve, seconds * 1000))
// Helper method to sleep a bit, then print balance of Alice and Bob
async function sleepAndPrintBalances() {
  console.log('Sleeping for a bit...')
  await sleep(15)
  await kin.getBalance(privateKeyAlice.publicKey()).then((b) => {
    console.log(`Balance for Alice:  ${quarksToKin(b)} Kin`)
  })
  await kin.getBalance(privateKeyBob.publicKey()).then((b) => {
    console.log(`Balance for Bob:    ${quarksToKin(b)} Kin`)
  })
}

// Execute the function one time before moving on so the accounts will be created
await sleepAndPrintBalances()
```

#### 6. Request Airdrop

We can now request and Airdrop for both of our token accounts. Note that this is only for the `Test` network.

In this example we'll request 10 Kin for both Alice and Bob.

```typescript
console.log('Request Airdrop for Alice')
await kin.requestAirdrop(tokenAccountsAlice[0], '10')

console.log('Request Airdrop for Bob')
await kin.requestAirdrop(tokenAccountsBob[0], '10')

await sleepAndPrintBalances()
```

#### 7. Send payment from Alice to Bob

Now we can send a payment from one account to the other.

```typescript
console.log('Submit P2P Payment from Alice to Bob')
await kin.submitP2P(privateKeyAlice, privateKeyBob.publicKey(), '2', 'My demo payment')

await sleepAndPrintBalances()
```
