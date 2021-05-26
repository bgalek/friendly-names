# Friendly names
> Simple and lightweight library that creates friendly names using nouns and adjectives. 

![GitHub Workflow Status](https://img.shields.io/github/workflow/status/bgalek/friendly-names/Build?style=flat-square)
![Codecov](https://img.shields.io/codecov/c/github/bgalek/friendly-names.svg?style=flat-square)
![GitHub Release Date](https://img.shields.io/github/release-date/bgalek/friendly-names.svg?style=flat-square)
![Libraries.io dependency status for GitHub repo](https://img.shields.io/librariesio/github/bgalek/friendly-names.svg?style=flat-square)
![Scrutinizer code quality](https://img.shields.io/scrutinizer/g/bgalek/friendly-names.svg?style=flat-square)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=bgalek_friendly-names&metric=alert_status)](https://sonarcloud.io/dashboard?id=bgalek_friendlyname)

## Usage

Add library dependency:
```groovy
compile "com.github.bgalek.security.utils:friendlynames:1.0.0"
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
