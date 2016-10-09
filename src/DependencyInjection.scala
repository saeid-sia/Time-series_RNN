

trait DBstore {
  def persist(user: User)
}

trait DatabaseRepo extends DBstore { /* ... */ }

trait UserService { self: DBstore => // requires DBstore
  def create(user: User) {
    // ...
    persist(user)
  }
}

new UserService with DatabaseRepo
