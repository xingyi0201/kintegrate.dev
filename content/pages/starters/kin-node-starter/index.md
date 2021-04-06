---
title: Kin Node Starter
date: Last Modified
permalink: starters/kin-node-starter/index.html
eleventyNavigation:
  key: KinNodeStarter
  order: 44
  parent: Starters
  title: Node
---


This section is being worked on and is coming soon.
## Introduction

This will get your Node.js app Kin enabled in a few minutes. All you need to do is add a simple class file to your app, and you should be able to make calls to Kin's blockchain immediately.

## Requirements

Make sure you have read [Getting Started](/tutorials/getting-started/) and have the required environment variables

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


## Demo App

A demo App is included that you can run and test. To use the app:

1. Pull https://github.com/kintegrate/kin-starter-node/ into a local folder
2. Access the `/src/main.ts` file on your local.
3. Use this code to test available methods
