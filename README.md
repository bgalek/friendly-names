# Friendly names
> Simple and lightweight library that creates friendly names using nouns and adjectives.

[![Build](https://github.com/bgalek/friendly-names/actions/workflows/build.yml/badge.svg?branch=main)](https://github.com/bgalek/friendly-names/actions/workflows/build.yml)
![Codecov](https://img.shields.io/codecov/c/github/bgalek/friendly-names.svg?style=flat-square)
![GitHub Release Date](https://img.shields.io/github/release-date/bgalek/friendly-names.svg?style=flat-square)
![Maven Central](https://img.shields.io/maven-central/v/com.github.bgalek.utils/friendly-names?style=flat-square)

## Usage

Add library dependency:
```groovy
implementation "com.github.bgalek.utils:friendly-names:1.0.0"
```

You can use this library generate user-friendly names:

```java
FriendlyNames.defaultDictionary(Locale.forLanguageTag("pl-PL")).random()

honorowa-mariola
```

```java
FriendlyNames.defaultDictionary().stream().limit(10).forEach(System.out::println)

little-virgie
strong-rachel
military-wes
black-lenard
clear-nelia
important-hans
good-lessie
hard-roxann
real-madelaine
easy-mariela
```

You can provide your own set of *nouns* and *adjectives*

```java
var dictionary = new FriendlyNamesDictionary(Set.of("noun"), Set.of("adjective"))
FriendlyNames.customDictionary(dictionary).random()

noun-adjective
```

## Features

- infinite stream of name combinations
- thread safe
- easy to use/extend
