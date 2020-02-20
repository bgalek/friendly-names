package com.github.bgalek.utils.friendlynames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

@DisplayName("FriendlyNameDictionary suite")
class FriendlyNamesDictionaryTest {

    @DisplayName("should throw exception for invalid dictionary")
    @ParameterizedTest(name = "names: {0} and adjectives: {1}")
    @MethodSource("invalidDictionarySets")
    void shouldThrowExceptionForInvalidDictionary(Set<String> names, Set<String> adjectives) {
        //expect
        Assertions.assertThrows(FriendlyNamesDictionaryException.class, () -> new DefaultFriendlyNamesDictionary(names, adjectives));
    }

    private static Stream<Arguments> invalidDictionarySets() {
        return Stream.of(
                Arguments.of(Set.of(), Set.of()),
                Arguments.of(Set.of(), Set.of("adjective")),
                Arguments.of(Set.of("name"), Set.of()),
                Arguments.of(null, null),
                Arguments.of(Set.of("name"), null),
                Arguments.of(null, Set.of("name"))
        );
    }
}