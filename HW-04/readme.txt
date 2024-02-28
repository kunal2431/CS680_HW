HW-04: Role Based Access application with State Design Pattern

This application demonstrates a role-based access system using the State design pattern. The application allows users to have different access levels for Guest, Premium User, and Admin pages each represented by a specific state.


1. <<Interface>> State : Methods for accessing the Guest page, PremiumUser page, Admin page, and logging out.

2. Users/states
   a) Guest : Guest user with access to Guest page only.
   b) PremiumUser : Premium user with access to Guest and PremiumUser Page only.
   c) Admin : Admin user with full access.

3. Each Users/States classes are implemented using the Singleton and Static factory methods are used in RoleBasedAccess class.

4. RoleBasedAccess class helps in creating instance of a particular user and accessing different pages.

5. Implemented and tested with JUnit by creating instances with different roles/users and observing their access levels.