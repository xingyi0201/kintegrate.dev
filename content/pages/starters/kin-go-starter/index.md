---
title: Kin Go Starter
date: Last Modified
permalink: starters/kin-go-starter/index.html
eleventyNavigation:
  key: KinGoStarter
  order: 42
  parent: Starters
  title: Go
---


## Introduction

This will get your Go app Kin enabled in a few minutes. All you need to do is add a simple class file to your app, and you should be able to make calls to Kin's blockchain immediately.

## Requirements

Make sure you have read [Getting Started](/tutorials/getting-started/) and have the required environment variables

#### 1. Install the Kin SDK for GO to your project:

```shell
go get -u github.com/kinecosystem/kin-go
```

#### 2. Create a Go app and add the [kinsdk.go](https://github.com/kintegrate/kin-starter-go/blob/main/kinsdk/kinsdk.go) package to your app

This package abstracts some calls to Kin's official SDK and is fully usable out of the box. However, you can easily extend it to suite your custom needs.

#### 3. Instantiate a new Kin client

We're creating a new instance of our Kin wrapper and pass in the environment. In this example we'll pick the Test network.

```go
// Set up Kin client
k, err := kinsdk.New(client.EnvironmentTest)
```

### Congratulations! You now have a Kin enabled app running!


## Demo App

A demo App is included that you can run and test. To use the app:

1. Pull https://github.com/kintegrate/kin-starter-go into a local folder
2. Access the `/main.go` file on your local.
3. Use this code to test available methods
