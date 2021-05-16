# Kintegrate.dev

Kintegrate.dev is a community-developer project with practical tutorials and start kits that help you to easily integrate the Kin blockchain in your apps.

## Contributing

If you want to contribute or make fixes to Kintegrate.dev, it is best to fork this repository directly and submit pull requests against it. If you spot a typo on the demo/documentation site, you can also open a fork directly from the edit button on the top of each page.

## Install spacebook

If you want to quickly install for local testing follow the instructions below:

### Requirements

You must be running **Node version 12 or higher** due to the Tailwind 2.0 release. I recommend using NVM to easily manage your Node versions if you need to switch back and forth between older versions.

- [Node](https://nodejs.org/)
- [NVM](https://github.com/nvm-sh/nvm) (optional)

**To find your current node version:**

```
node --version
```

### Step one

```
git clone https://github.com/kintegrate/kintegrate.dev
```

### Step two

Install the site and run an initial build command:

```
cd kintegrate.dev

yarn install

yarn build (only necessary the first time!)
```

_If you get errors here, double-check your node version!_

### Step three

Now spin up your local server to see your site!

```
yarn start
```

This command will start a local server, and you'll be able to work on your site with hot reloads and some nice Browsersync features. 💥

---

# Talk to us!

If you have issues getting started with this project, get in touch on [Discord](https://discord.gg/kdRyUNmHDn).
