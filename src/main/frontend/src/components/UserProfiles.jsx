import React, { useState, useEffect } from "react";
import axios from "axios";

function UserProfiles() {
  const [userProfiles, setUserProfiles] = useState([]);

  const fetchUserProfiles = () => {
    axios
      .get("http://localhost:8080/api/v1/user-profile")
      .then((res) => {
        console.log(res);
        if (JSON.stringify(userProfiles) !== JSON.stringify(res.data))
          setUserProfiles(res.data);
      })
      .catch((err) => console.log(err));
  };

  useEffect(() => {
    fetchUserProfiles();
  }, [userProfiles]);

  return userProfiles.map((userProfile, index) => {
    return (
      <div key={index}>
        <h1>{userProfile.username}</h1>
        <p>{userProfile.userProfileId}</p>
      </div>
    );
  });
}

export default UserProfiles;
