package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserType {
    PHYSICAL("Физ. лицо"),
    LEGAL("Юридическое лицо");

    private final String name;
}