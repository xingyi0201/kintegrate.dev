---
title: Home
date: Last Modified
permalink: /
eleventyNavigation:
  key: Home
  order: 0
  title: Home
---

This is the Homepage!

Here we can add things and stuff!

Nulla efficitur consectetur elementum. Morbi diam purus, efficitur sed viverra in, congue pulvinar sapien. Vestibulum in tellus in diam accumsan auctor luctus in lacus. Praesent quis ullamcorper nibh, at laoreet mauris. Cras non congue arcu, quis sodales sapien. Curabitur pretium vitae sapien vel feugiat. Quisque interdum mollis elit, id congue dolor semper id. Fusce facilisis dapibus tellus. Vivamus vitae semper dui, rutrum finibus nulla. Aliquam odio sem, consequat sit amet rutrum id, malesuada sit amet risus. Curabitur imperdiet lectus vitae ultrices vestibulum. Suspendisse egestas ac magna eu ultrices. Nulla blandit sollicitudin ultrices. Curabitur in sem semper, tristique libero id, tristique ipsum. Etiam ullamcorper odio at nulla interdum feugiat non at est. Sed maximus, nisl in luctus auctor, lacus turpis porttitor orci, nec feugiat mauris tortor non risus.

```graphviz
digraph {
  compound=true

  graph [ fontname="Source Sans Pro", fontsize=20 ];
  node [ fontname="Source Sans Pro", fontsize=18];
  edge [ fontname="Source Sans Pro", fontsize=12 ];

  kin [label="Kin Blockchain"]

  kin -> agora  [dir="both"]

  agora -> server  [dir="both"]
  agora -> client  [dir="both"]

  subgraph api {
    agora [label="Agora"]
    label="API"
  }

  subgraph backend {
    label="Backend"

    server      [label="Server SDK"]
  }

  subgraph frontend {
    label="Client App"

    client      [label="Client SDK"]
  }
}
```

---
