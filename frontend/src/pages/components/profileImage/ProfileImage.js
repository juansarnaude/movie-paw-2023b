import React from "react";
import "./profileImage.css";
import defaultProfilePicture from "../../../images/defaultProfilePicture.png";

const ProfileImage = ({ image, username, size, onClick }) => {
    const imgSrc = image || defaultProfilePicture;

    return (
        <img
            id="profile-image"
            className="profileImage"
            style={{ height: size, width: size, cursor: 'pointer' }}
            src={imgSrc}
            alt="Profile"
            onClick={onClick}  // Added onClick handler
            onError={(e) => {
                e.target.src = defaultProfilePicture; // Reemplaza la imagen con la predeterminada
            }}
        />
    );
};

export default ProfileImage;
