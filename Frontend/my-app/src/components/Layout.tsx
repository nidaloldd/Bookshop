/** @format */

import { FunctionComponent, ReactNode } from "react";
import "../App.css";
import Navigation from "../components/Navigation";
import Footer from "../components/Footer";

interface LayoutProps {
  children: ReactNode | undefined;
}
const Layout: FunctionComponent<LayoutProps> = ({ children }) => {
  return (
    <>
      <main className=" min-h-screen bg-gray-900 text-sky-50 font-sans">
        <Navigation></Navigation>
        {children}
      </main>
      <Footer></Footer>
    </>
  );
};
export default Layout;
