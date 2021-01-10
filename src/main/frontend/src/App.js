// import React, { useState, useEffect } from "react";
import UserProfiles from "./components/UserProfiles";
// import logo from "./logo.svg";
import "./App.css";
// import axios from "axios";

// const UserProfiles = () => {
//   const fetchUserProfiles = () => {
//     axios
//       .get("http://localhost:8080/api/v1/user-profile")
//       .then((res) => {
//         console.log(res);
//       })
//       .catch((err) => console.log(err));
//   };

//   useEffect(() => {
//     fetchUserProfiles();
//   }, []);

//   return <h1>Hello</h1>;
// };

function App() {
  return (
    <div className="App">
      <UserProfiles />
    </div>
  );
}

export default App;
