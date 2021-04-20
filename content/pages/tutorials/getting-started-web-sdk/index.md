---
title: Getting Started with the Web SDK
date: Last Modified
permalink: tutorials/getting-started-web-sdk/index.html
eleventyNavigation:
  key: TutorialsGettingStartedWebSdk
  order: 25
  parent: TutorialsGettingStarted
  title: Web
---

## Introduction

This tutorial will take you through the basics of creating a Kin enabled app using `@kin-sdk/client`.

## Requirements

## Implementing Kin in your app

#### 1. Install the Kin Web SDK to your project:

```shell
npm install @kin-sdk/client
# Or if you use yarn
yarn add @kin-sdk/client
```

#### 2. Create a React app and add the

This class abstracts some calls to Kin's official SDK and is fully usable out of the box. However, you can easily extend it to suite your custom needs.

#### 3. Instantiate a new Kin client

We're creating a new instance of our Kin wrapper and pass in the environment. In this example we'll pick the Test network.

```typescript
// Import KinClient and the Kin environment object
import { KinClient, KinTest } from '@kin-sdk/client'
// Set up Kin client
const kin = new KinClient(KinTest)
```

### Congratulations! You now have a Kin enabled app running!

## Making calls to the Kin blockchain

In this example, we're going to create a new wallet for both Alice and Bob by generating new key pair. After the wallet is created, Alice will send a P2P transaction to Bob.

#### 4. Create account for Alice

We create a new private key-pair for Alice, then call into our wrapper to create a new account. After creation, we log out the public address of both the wallet, and the token accounts

```typescript
const account = KinClient.createWallet('create', { name: 'Alice' })

const [res, err] = await client.createAccount(account.secret!)

if (err) {
  throw new Error(`Could not create account`)
}

console.lg(res)
```

#### 5. Request Airdrop

We can now request and Airdrop for both of our token accounts. Note that this is only for the `Test` network.

In this example we'll request 10 Kin for both Alice and Bob.

```typescript
console.log('Request Airdrop for Alice')
await kin.requestAirdrop(account.publicKey, '10')
```

#### 6. Send payment from Alice

Now we can send a payment from one account to the other.

```typescript
console.log('Submit P2P Payment from Alice to Bob')
const dest = `Don8L4DTVrUrRAcVTsFoCRqei5Mokde3CV3K9Ut4nAGZ`
await kin.sendPayment(account.secret, dest, '10', 'My donation')
```
