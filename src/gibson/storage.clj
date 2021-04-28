(ns gibson.storage)

;; Protocol needs:
;; CRUD Links using IDs & List all known links
(defprotocol Storage
  (create-link [this id url]
    "Store the url under the id. Returns the id if successful, nil if id in use")
  (get-link [this id]
    "Given id returns associated url. Returns nil if no associate url")
  (update-link [this id new-url]
    "Updates id to point to new-url. Returns id if successful, nil if not created")
  (delete-link [this id]
    "Removes a link with given id in storage if it exists")
  (list-links [this]
    "Returns a map of all known id's to url's")
  )