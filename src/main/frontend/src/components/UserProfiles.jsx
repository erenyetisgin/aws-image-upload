import React, { useState, useEffect } from "react";
import axios from "axios";
import DropZone from "./DropZone";

function UserProfiles() {
  const [userProfiles, setUserProfiles] = useState([]);

  const fetchUserProfiles = () => {
    axios
      .get("http://localhost:8080/api/v1/user-profile")
      .then((res) => {
        console.log(res);
        setUserProfiles(res.data);
      })
      .catch((err) => console.log(err));
  };

  useEffect(() => {
    fetchUserProfiles();
  }, []);

  return userProfiles.map((userProfile, index) => {
    return (
      <div key={index}>
        <DropZone />
        <h1>{userProfile.username}</h1>
        <p>{userProfile.userProfileId}</p>
      </div>
    );
  });
}

export default UserProfiles;
