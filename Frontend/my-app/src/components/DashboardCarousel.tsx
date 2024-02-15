/** @format */

import "../App.css";
import Carousel from "./Carousel";

function DashboardCarousel() {
  const heroItems = [
    <div key="1">
      <section className="bg-gradient-to-r from-purple-800 via-purple-600 to-blue-600 text-white py-24 px-4">
        <div className="container mx-auto text-center">
          <h1 className="text-6xl font-extrabold mb-4">Immerse in Reading</h1>
          <p className="text-lg mb-8">
            Discover captivating stories that transport you to different worlds.
          </p>
          <a
            href="#"
            className="bg-white text-purple-800 px-8 py-3 rounded-full font-semibold hover:bg-purple-200"
          >
            Explore Now
          </a>
        </div>
      </section>
    </div>,
    <div key="2">
      <section className="bg-gradient-to-r from-blue-600 to-purple-800 text-white py-24 px-4">
        <div className="container mx-auto text-center">
          <h1 className="text-6xl font-semibold mb-4">Discover a New World</h1>
          <p className="text-lg mb-8">
            Explore a curated collection of books just for you.
          </p>
          <a
            href="#"
            className="bg-white text-blue-500 px-6 py-3 rounded-full font-semibold hover:bg-blue-400"
          >
            Start Browsing
          </a>
        </div>
      </section>
    </div>,
  ];
  return <Carousel items={heroItems}></Carousel>;
}

export default DashboardCarousel;
