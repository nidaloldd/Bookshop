/** @format */

import { FunctionComponent } from "react";
import "../App.css";

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

const reviews = [
  {
    id: 1,
    reviewer: "Alice",
    content: "An amazing adventure! Couldn't put it down!",
  },
  {
    id: 2,
    reviewer: "Bob",
    content: "Fantastic read! Highly recommend it to all fantasy lovers.",
  },
  {
    id: 3,
    reviewer: "Charlie",
    content: "Captivating from start to finish. Five stars!",
  },
];
const aboutAuthor =
  "Jackson Blackthorn is an acclaimed author known for his captivating storytelling and imaginative worlds. He has written several bestselling novels.";
const description =
  "In a world of forgotten tales and lost legends, a brave adventurer embarks on a journey to uncover the secrets of the mystical Forgotten Library.";
const BookProfileContent: FunctionComponent<Books> = ({
  id,
  title,
  author,
  genres,
  price,
}) => {
  return (
    <>
      {/* Content */}
      <div className="min-h-screen flex flex-col ">
        <div className="flex-grow flex justify-center">
          <div className=" p-8 bg-gradient-to-t from-gray-700 to-gray-800 rounded-lg shadow-lg">
            {/* Book details */}
            <div className="flex mb-8">
              <img
                className="w-64 rounded-lg mr-6"
                src={`http://localhost:8081/img/${id}`}
                alt="Book Cover"
              />
              <div>
                <h2 className="text-3xl font-semibold mb-2">{title}</h2>
                <h3 className="text-xl  mb-4">by {author}</h3>
                <p className="mb-4">
                  <span className="font-semibold">Genres:</span>{" "}
                  {genres.map((genre, index) => (
                    <span key={index}>{genre.genreType} </span>
                  ))}
                </p>
                <p className=" mb-8">
                  <span className="font-semibold">Price:</span> $
                  {price.toFixed(2)}
                </p>
                <button className="bg-blue-500 hover:bg-blue-600 text-white py-2 px-4 rounded-md shadow-md focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-opacity-50">
                  Buy Now
                </button>
              </div>
            </div>

            {/* Description */}
            <div className="mb-8">
              <h2 className="text-2xl font-semibold mb-4">Description</h2>
              <p>{description}</p>
            </div>

            {/* About the Author */}
            <div className="mb-8">
              <h2 className="text-2xl font-semibold mb-4">About the Author</h2>
              <p>{aboutAuthor}</p>
            </div>

            {/* Reviews */}
            <div>
              <h2 className="text-2xl font-semibold mb-4">Reviews</h2>
              {reviews.map((review) => (
                <div key={review.id} className="mb-4">
                  <h3 className="text-lg font-semibold">{review.reviewer}</h3>
                  <p>{review.content}</p>
                </div>
              ))}
            </div>
          </div>
        </div>
      </div>
    </>
  );
};
export default BookProfileContent;
