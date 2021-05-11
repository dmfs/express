[![Build Status](https://travis-ci.org/dmfs/express.svg?branch=master)](https://travis-ci.org/dmfs/express)
[![codecov](https://codecov.io/gh/dmfs/express/branch/master/graph/badge.svg)](https://codecov.io/gh/dmfs/express)

# express

**express** verb [transitive] _/ɪkˈspres/_ (express oneself) Say or otherwise communicate what one thinks or means. 

**express** adverb _/ɪkˈspres/_ Operating at high speed. 

## Rationale

The JSON format, specified in [RFC 8259](https://tools.ietf.org/html/rfc8259), is used for data interchange in many protocols.

There are quite a few Java implementations which can parse and/or generate JSON text. Unfortunately most implementations
are based on mutable POJOs and require the entire JSON structure to be constructed in memory before it can be serialized.

This library aims to provide a simple declarative way of generating JSON text. It allows you to express yourself directly in JSON, using Java notation.
It's meant for use cases when you need to create JSON texts without having to parse the same document type. A common use case is sending data to a JSON based API.

Parsing JSON text is currently not supported although it might be added later on.

Note, the interfaces defined in this library may be subject to change. However, this is not considered an issue when using this in production, because
it's unlikely that you need to implement any of the interfaces of this library yourself. 

## Basic usage

This library defines a simple interface called `JsonValue` which represents a JSON value and an implementation for each of the elementary
JSON types: Object, array, string, number, and the literals `null`, `true`, `false`.

The basic implementations use the name names (except for `true` and `false` which are covered by a `Boolean` type). Note, even thought the classes
`String`, `Number` and `Boolean` of this library "conflict" with the JDK classes having the same names this is not considered an issue because you'll
barely get in touch with these (only in case you create a mixed type array with string, numbers and/or booleans).  

Declaring a `JsonValue` is done like

```java
JsonValue json = new Object(
    new Member("@class", "album"),
    new Member("title", "Ommadawn"),
    new Member("artist", "Mike Oldfield"),
    new Member("tracks", new Array(
        new Object(
            new Member("@class", "track"),
            new Member("title", "Ommadawn – Part One"),
            new Member("duration", 1163)),
        new Object(
            new Member("@class", "track"),
            new Member("title", "Ommadawn – Part Two"),
            new Member("duration", 834)),
        new Object(
            new Member("@class", "track"),
            new Member("title", "On Horseback"),
            new Member("duration", 203)))));
```  

which corresponds to the following JSON text (pretty printed version)

```JSON
{
  "@class": "album",
  "title":  "Ommadawn",
  "artist": "Mike Oldfield",
  "tracks": [{
    "@class": "track",
    "title":  "Ommadawn – Part One",
    "duration": 1163
  },{
    "@class": "track",
    "title":  "Ommadawn – Part Two",
    "duration": 834
  },{
    "@class": "track",
    "title":  "On Horseback",
    "duration": 203
  }]
}
```

The Java code has (almost) the same structure as the JSON result.

Turning the `JsonValue` into a JSON Text is done with

```java
String jsonText = new JsonText(json).value();
```

### Composition of complex objects

`DelegatingJsonValue` is an abstract class allowing for easy composition of complex JSON values.

The following two classes represent valid composite JSON values

```java
public final class Album extends DelegatingJsonValue
{
    public Album(String title, String artist, Iterable<Track> tracks)
    {
        super(new Object(
            new Member("@class", "album"),
            new Member("title", title),
            new Member("artist", artist),
            new Member("tracks", tracks)));
    }
}

public final class Track extends DelegatingJsonValue
{
    public Track(String title, int durationSeconds)
    {
        super(new Object(
            new Member("@class", "track"),
            new Member("title", title),
            new Member("duration", durationSeconds)));
    }
}
```

They allow to simplify the JSON Album declaration to
```java
new JsonText(new Album(
    "Ommadawn",
    "Mike Oldfield",
    new Seq<>(
        new Track("Ommadawn – Part One", 1163),
        new Track("Ommadawn – Part Two", 834),
        new Track("On Horseback", 203)
    )))
    .value();
```

Which generates the same JSON text as in the first example.

## Limitations

At present this library has the following limitations

* no parser for JSON text
* no way to update JsonValues once created
* no pretty printed output


## License

Copyright 2018 dmfs GmbH

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.