/** @format */

import "../App.css";
import { useEffect, useState } from "react";
import Navigation from "../components/Navigation";
import Footer from "../components/Footer";
import SampleBooksCard from "../components/SampleBookCard";
import DashboardCarousel from "../components/DashboardCarousel";
import Layout from "../components/Layout";

interface Books {
  id: number;
  title: string;
  author: string;
  genres: Genre[];
  price: number;
}
interface Genre {
  genreType: string;
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

  return (
    <Layout>
      <DashboardCarousel></DashboardCarousel>

      {/* Featured Books */}
      <section className="py-20 px-4">
        <div className="container mx-auto">
          <h2 className="text-4xl font-extrabold mb-12 text-center">
            Featured Books
          </h2>
          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-12">
            {bookData &&
              bookData.map((book: Books) => (
                <SampleBooksCard
                  id={book.id}
                  title={book.title}
                  author={book.author}
                  genres={book.genres}
                  price={book.price}
                ></SampleBooksCard>
              ))}
          </div>
        </div>
      </section>
    </Layout>
  );
}

export default Dashboard;
