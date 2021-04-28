(ns gibson.storage-test
  (:require [gibson.storage :refer :all]
            [gibson.memoryDB :refer :all]
            [clojure.test :refer :all]))

(defn is-valid-storage
  "Given an implementation of the Storage protocol, asserts it fulfills contract."
  [stg]
  (let [url "http://example.com/clojurebook"
        id "book"]
    (testing "can store and retrieve a link"
      (testing "create-link returns the id"
        (is (= id (create-link stg id url)))

        (testing "does not overwrite existing id"
          (is (nil? (create-link stg id "bogus")))
          (is (= url (get-link stg id))))))

    (testing "can update a link"
      (let [new-url "http://example.com/another"]
        (update-link stg id new-url)
        (is (= new-url (get-link stg id)))))

    (testing "can delete a link"
      (delete-link stg id)
      (is (nil? (get-link stg id))))))

(deftest in-memory-storage-test
  (let [stg (gibson.memoryDB/memory-database)]
    (is-valid-storage stg)))