package com.github.bgalek.utils.friendlynames;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("FriendlyName suite")
class FriendlyNamesTest {

    @Test
    @DisplayName("should generate friendly name based on default dictionary")
    void generateFriendlyNameUsingDefaultDictionary() {
        //given
        String random = FriendlyNames.defaultDictionary().random();

        //expect
        assertFormat(random);
    }

    @Test
    @DisplayName("should generate friendly name based on default dictionary with given Locale")
    void generateFriendlyNameUsingDefaultAndLocale() {
        //given
        String random1 = FriendlyNames.defaultDictionary(Locale.ENGLISH).random();
        String random2 = FriendlyNames.defaultDictionary(Locale.forLanguageTag("pl_PL")).random();

        //expect
        assertFormat(random1);
        assertFormat(random2);
        assertNotSame(random1, random2);
    }

    @Test
    @DisplayName("should generate friendly name based on given dictionary")
    void generateOneFriendlyName() {
        //given
        Set<String> names = Set.of("bartosz");
        Set<String> adjectives = Set.of("silny");
        FriendlyNames friendlyNames = FriendlyNames.customDictionary(new DefaultFriendlyNamesDictionary(names, adjectives));

        //expect
        assertEquals("silny-bartosz", friendlyNames.random());
    }

    @Test
    @DisplayName("should generate friendly names infinitely")
    void generateInfiniteAmountOfFriendlyNames() {
        //given
        Set<String> names = Set.of("bartosz");
        Set<String> adjectives = Set.of("silny");
        FriendlyNames friendlyNames = FriendlyNames.customDictionary(new DefaultFriendlyNamesDictionary(names, adjectives));

        //expect
        assertEquals(
                List.of("silny-bartosz", "silny-bartosz", "silny-bartosz"),
                friendlyNames.stream().limit(3).collect(Collectors.toList())
        );
    }

    @Test
    @DisplayName("should generate unique friendly name based on given dictionary")
    void generateUniqueFriendlyNames() {
        //given
        Set<String> names = Set.of("bartosz", "paweł", "michał", "piotr");
        Set<String> adjectives = Set.of("silny", "szybki", "śmiały");
        DefaultFriendlyNamesDictionary friendlyNamesDictionary = new DefaultFriendlyNamesDictionary(names, adjectives);
        FriendlyNames friendlyNames = FriendlyNames.customDictionary(friendlyNamesDictionary);

        //expect;
        assertEquals(
                names.size() * adjectives.size(),
                IntStream.range(0, 1000).mapToObj(it -> friendlyNames.random()).collect(Collectors.toSet()).size()
        );
    }

    @Test
    @DisplayName("should generate friendly names stream")
    void generateFriendlyNameFromStream() {
        //given
        Set<String> names = Set.of("bartosz", "paweł");
        Set<String> adjectives = Set.of("silny", "szybki");
        DefaultFriendlyNamesDictionary friendlyNamesDictionary = new DefaultFriendlyNamesDictionary(names, adjectives);

        //when
        Set<String> friendlyNames = FriendlyNames.customDictionary(friendlyNamesDictionary).stream().limit(2).collect(Collectors.toSet());

        //expect
        friendlyNames.forEach(it ->
                assertTrue(adjectives.contains(it.split("-")[0]) && names.contains(it.split("-")[1]))
        );
    }

    private void assertFormat(String random) {
        assertTrue(random.matches("[A-Za-zÀ-ÖØ-öø-ÿ]+-[A-Za-zÀ-ÖØ-öø-ÿ]+"));
    }
}