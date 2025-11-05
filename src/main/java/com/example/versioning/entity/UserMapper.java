package com.example.versioning.entity;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO tov1(User user){
        return new UserDTO(
                user.id(), user.name(), user.email(), user.website()
        );
    }

    public UserDTOV2 tov2(User user){
        String[] nameparts = splitName(user.name());
        return new UserDTOV2(
                user.id(), nameparts[0], nameparts[1], user.email()
        );
    }
    private String[] splitName(String fullName) {
        // Smart splitting logic that handles edge cases
        // like middle names and single-word names
        if (fullName == null || fullName.trim().isEmpty()) {
            return new String[]{"", ""};
        }

        String trimmed = fullName.trim();
        int lastSpaceIndex = trimmed.lastIndexOf(' ');

        if (lastSpaceIndex == -1) {
            return new String[]{trimmed, ""};
        }

        return new String[]{
                trimmed.substring(0, lastSpaceIndex),
                trimmed.substring(lastSpaceIndex + 1)
        };
    }
}
