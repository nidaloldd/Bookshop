/** @format */

import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Dashboard from "./pages/Dashboard";
import BookProfile from "./pages/BookProfile";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Dashboard />} />
        <Route path="/Dashboard" element={<Dashboard />} />
        <Route path="/BookProfile" element={<BookProfile />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
