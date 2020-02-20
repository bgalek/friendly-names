package com.github.bgalek.utils.friendlynames;

public final class FriendlyNamesDictionaryException extends RuntimeException {
    FriendlyNamesDictionaryException(String message) {
        super(String.format("Invalid dictionary: %s", message));
    }
}
