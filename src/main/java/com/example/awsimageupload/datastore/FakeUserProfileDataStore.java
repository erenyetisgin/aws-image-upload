package com.example.awsimageupload.datastore;

import com.example.awsimageupload.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {

    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.fromString("2af46068-d2eb-4c5a-ba8d-a6cf08fd8110"),
                "Murtaza",
                null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("97006c3d-5454-4c2b-b331-39535796c1f7"),
                "Saban",
                null));
    }

    public List<UserProfile> getUserProfiles() {
        return USER_PROFILES;
    }
}
