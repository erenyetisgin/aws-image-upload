import React, { useState, useEffect } from "react";
import axios from "axios";
import Dropzone from "./Dropzone";

function UserProfiles() {
  const [userProfiles, setUserProfiles] = useState([]);

  const fetchUserProfiles = () => {
    axios
      .get("http://localhost:8080/api/v1/user-profile")
      .then((res) => {
        setUserProfiles(res.data);
      })
      .catch((err) => console.error(err));
  };

  useEffect(() => {
    fetchUserProfiles();
  }, []);

  return userProfiles.map((userProfile, index) => {
    return (
      <div key={index}>
        {userProfile.userProfileId ? (
          <img
            src={`http://localhost:8080/api/v1/user-profile/${userProfile.userProfileId}/image/download`}
          />
        ) : null}
        <br />
        <br />
        <h1>{userProfile.username}</h1>
        <p>{userProfile.userProfileId}</p>
        <Dropzone {...userProfile} />
        <br />
      </div>
    );
  });
}

export default UserProfiles;
