/** @format */

import "../App.css";
import { useEffect, useState } from "react";

interface Books {
  id: number;
  title: string;
  author: string;
  genre: string;
  price: number;
  imageSource: string;
}

function Dashboard() {
  const [data, setData] = useState<Books[]>();
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    fetch("/api")
      .then((response) => response.json())
      .then((data) => {
        setData(data);
      });
  }, []);

  return (
    <main className="bg-gray-100 font-sans">
      <div className="bg-blue-500 p-4">
        <div className="container mx-auto flex justify-between items-center">
          <h1 className="text-white text-2xl font-bold">Elegant Bookshop</h1>
          <nav className="space-x-4">
            <a href="#" className="text-white">
              Home
            </a>
            <a href="#" className="text-white">
              Browse
            </a>
            <a href="#" className="text-white">
              Contact
            </a>
          </nav>
        </div>
      </div>

      <h1 className="text-3xl font-bold mb-8 text-center">Elegant Bookshop</h1>

      <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-8">
        {data &&
          data.map((costumer: Books) => (
            <>
              <div className="bg-white rounded-lg overflow-hidden shadow-md">
                <div className="relative">
                  <img
                    src={costumer.imageSource}
                    alt="Book Cover"
                    className="w-full h-64 object-cover"
                  />
                  <span className="absolute top-0 right-0 bg-green-500 text-white px-2 py-1 m-2 rounded-full">
                    New
                  </span>
                </div>
                <div className="p-4">
                  <h2 className="text-xl font-bold mb-2">{costumer.title}</h2>
                  <p className="text-gray-700 mb-4">{costumer.author}</p>
                  <p className="text-gray-600">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                  </p>
                  <div className="mt-4">
                    <span className="text-gray-700">
                      Price: ${costumer.price}
                    </span>
                    <button className="bg-blue-500 text-white px-4 py-2 rounded-md float-right">
                      Add to Cart
                    </button>
                  </div>
                </div>
              </div>
            </>
          ))}
      </div>
    </main>
  );
}

export default Dashboard;
