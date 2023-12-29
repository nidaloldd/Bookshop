/** @format */

import "../App.css";
import { useEffect, useState } from "react";
import logo from "./logo.svg";
import Carousel from "../components/Carousel";

interface Books {
  id: number;
  title: string;
  author: string;
  genre: string;
  price: number;
  imageSource: string;
}

function Dashboard() {
  const [bookData, setBookData] = useState<Books[]>();
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    fetch("/api/allBooks")
      .then((response) => response.json())
      .then((bookData) => {
        setBookData(bookData);
      });
  }, []);

  // Sample hero items
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
    // Add more hero items as needed
  ];

  return (
    <main className="bg-gray-900 text-sky-50 font-sans">
      {/* Navigation */}
      <nav className="bg-transparent p-4">
        <div className="container mx-auto flex justify-between items-center">
          <a href="#" className="text-3xl font-bold">
            Bookstore
          </a>
          <ul className="flex space-x-4">
            <li>
              <a href="#" className="hover:text-gray-300">
                Home
              </a>
            </li>

            <li>
              <a href="#" className="hover:text-gray-300">
                Books
              </a>
            </li>
            <li>
              <a href="#" className="hover:text-gray-300">
                About
              </a>
            </li>
            <li>
              <a href="#" className="hover:text-gray-300">
                Contact
              </a>
            </li>
          </ul>
        </div>
      </nav>

      {/* Hero Section */}

      <Carousel items={heroItems}></Carousel>

      {/* Featured Books */}

      <section className="py-20 px-4">
        <div className="container mx-auto">
          <h2 className="text-4xl font-extrabold mb-12 text-center">
            Featured Books
          </h2>
          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-12">
            {/* Sample Book Card */}

            {bookData &&
              bookData.map((costumer: Books) => (
                <div className="bg-gradient-to-t from-gray-700 to-gray-800 rounded-lg shadow-lg overflow-hidden">
                  <img
                    src={`http://localhost:8081/img/${costumer.id}`}
                    alt="Book Cover"
                    className="w-full h-72 object-cover"
                  />
                  <div className="p-6">
                    <a href="" className="hover:text-gray-400">
                      <h3 className="text-2xl font-semibold mb-3">
                        {costumer.title}
                      </h3>
                    </a>

                    <a href="" className="hover:text-gray-400">
                      <p className="mb-3">{costumer.author}</p>
                    </a>

                    <div className="flex justify-between items-center ">
                      <span className="text-xl font-bold text-orange-400">
                        ${costumer.price}
                      </span>
                      <button className="bg-blue-600 text-white px-5 py-2 rounded-full hover:bg-blue-700">
                        Add to Cart
                      </button>
                    </div>
                  </div>
                </div>
              ))}
          </div>
        </div>
      </section>

      {/* Footer */}
      <footer className="bg-gray-800 text-gray-400 py-16">
        <div className="container mx-auto text-center">
          <p>&copy; 2023 Bookstore. All rights reserved.</p>
        </div>
      </footer>
    </main>
  );
}

export default Dashboard;
