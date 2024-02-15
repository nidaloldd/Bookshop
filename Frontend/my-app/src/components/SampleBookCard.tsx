/** @format */

import { FunctionComponent } from "react";
import "../App.css";
import { useNavigate } from "react-router-dom";

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

const SampleBooksCard: FunctionComponent<Books> = ({
  id,
  title,
  author,
  genres,
  price,
}) => {
  const navigate = useNavigate();
  const toBookProfile = (
    id: number,
    title: string,
    author: string,
    genres: Genre[],
    price: number
  ) => {
    navigate("/BookProfile", {
      state: {
        id: id,
        title: title,
        author: author,
        genres: genres,
        price: price,
      },
    });
  };
  return (
    <>
      <div className="bg-gradient-to-t from-gray-700 to-gray-800 rounded-lg shadow-lg overflow-hidden">
        <img
          src={`http://localhost:8081/img/${id}`}
          alt="Book Cover"
          className="w-full h-72 object-cover"
        />

        <div className="p-6">
          <a href="" className="hover:text-gray-400">
            <h3 className="text-2xl font-semibold mb-3">
              <button
                onClick={() => {
                  toBookProfile(id, title, author, genres, price);
                }}
              >
                {title}
              </button>
            </h3>
          </a>

          <a href="" className="hover:text-gray-400">
            <p className="mb-3">{author}</p>
          </a>

          <div>
            {genres.map((genre, index) => (
              <span key={index}>{genre.genreType} </span>
            ))}
          </div>

          <div className="flex justify-between items-center ">
            <span className="text-xl font-bold text-orange-400">${price}</span>
            <button className="bg-blue-600 text-white px-5 py-2 rounded-full hover:bg-blue-700">
              Add to Cart
            </button>
          </div>
        </div>
      </div>
    </>
  );
};
export default SampleBooksCard;
