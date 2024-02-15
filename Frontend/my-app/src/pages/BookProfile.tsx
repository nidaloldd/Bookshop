/** @format */

import "../App.css";
import { useEffect, useState } from "react";
import BookProfileContent from "../components/BookProfileContent";
import { Link, useLocation } from "react-router-dom";
import Footer from "../components/Footer";
import Navigation from "../components/Navigation";
import Layout from "../components/Layout";

function BookProfile() {
  const location = useLocation();
  return (
    <Layout>
      <BookProfileContent
        id={location.state.id}
        title={location.state.title}
        author={location.state.author}
        genres={location.state.genres}
        price={location.state.price}
      ></BookProfileContent>
    </Layout>
  );
}

export default BookProfile;
