package pl.wsb.fitnesstracker.user.internal;

import jakarta.annotation.Nullable;

// DTO wysylane przez siec dla listy podstawowych informacji o uzytkownikach.
record UserSummaryDto(@Nullable Long id, String firstName, String lastName) {
}
