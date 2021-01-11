package com.example.awsimageupload.profile;

import com.example.awsimageupload.datastore.FakeUserProfileDataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
public class UserProfileService {

    private final UserProfileDataAccessService userProfileDataAccessService;

    @Autowired
    public UserProfileService(UserProfileDataAccessService userProfileDataAccessService) {
        this.userProfileDataAccessService = userProfileDataAccessService;
    }

    List<UserProfile> getUserProfiles() {
        return userProfileDataAccessService.getUserProfiles();
    }

    public void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {
        if(!file.isEmpty() && file.getContentType().contains("image")) {
            System.out.println("File is not empty and it's an image");
            List<UserProfile> userProfileList = getUserProfiles();
            if(userProfileList.stream()
                    .filter(userProfile -> userProfileId.equals(userProfile.getUserProfileId()))
                    .findAny()
                    .orElse(null) != null) {
                System.out.println("User exists in database");
                System.out.println(file.getOriginalFilename());
            }
            else System.out.println("User does NOT exist in database");
        }
        else {
            System.out.println("File is empty or it's not an image");
        }
    }
}
