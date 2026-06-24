/* public User(
    String name,
    String email,
    String phone,
    String address,
    int age,
    String country,
    String linkedin,
    String github)

    User user =
        new User(
            "Priyanshu",
            "abc@gmail.com",
            "999999999",
            "Bangalore",
            26,
            "India",
            "linkedin",
            "github"
        );

    Now initilizing it become a bit verbose

    // Cleaner alternative

    User user =
        new UserBuilder()
            .name("Priyanshu")
            .email("abc@gmail.com")
            .country("India")
            .build();



*/

// class User {

//     private String name;
//     private String email;

//     private User(Builder builder) {
//         this.name = builder.name;
//         this.email = builder.email;
//     }

//     public static class Builder {

//         private String name;
//         private String email;

//         public Builder name(String name) {
//             this.name = name;
//             return this;
//         }

//         public Builder email(String email) {
//             this.email = email;
//             return this;
//         }

//         public User build() {
//             return new User(this);
//         }
//     }

//     @Override
//     public String toString() {
//         return (
//             "User{" + "name='" + name + '\'' + ", email='" + email + '\'' + '}'
//         );
//     }
// }

// class Main {

//     public static void main(String[] args) {
//         User user = new User.Builder()
//             .name("Priyanshu")
//             .email("abc@gmail.com")
//             .build();
//         System.out.println(user.toString());
//     }
// }

/* Let's solve a realistic Builder problem:

Design a House object with:

mandatory:
- foundation
- walls

optional:
- garage
- swimmingPool
- garden
- solarPanels
- securitySystem

Try implementing the Builder yourself.

You'll immediately see why Builders shine when a class has many optional fields. This is the classic Builder interview problem. */

class House {

    private final String foundation;
    private final String walls;

    private final boolean garage;
    private final boolean swimmingPool;
    private final boolean garden;
    private final boolean solarPanels;
    private final boolean securitySystem;

    private House(Builder builder) {
        this.foundation = builder.foundation;
        this.walls = builder.walls;

        this.garage = builder.garage;
        this.swimmingPool = builder.swimmingPool;
        this.garden = builder.garden;
        this.solarPanels = builder.solarPanels;
        this.securitySystem = builder.securitySystem;
    }

    @Override
    public String toString() {
        return (
            "House{" +
            "foundation='" +
            foundation +
            '\'' +
            ", walls='" +
            walls +
            '\'' +
            ", garage=" +
            garage +
            ", swimmingPool=" +
            swimmingPool +
            ", garden=" +
            garden +
            ", solarPanels=" +
            solarPanels +
            ", securitySystem=" +
            securitySystem +
            '}'
        );
    }

    public static class Builder {

        private String foundation;
        private String walls;

        private boolean garage;
        private boolean swimmingPool;
        private boolean garden;
        private boolean solarPanels;
        private boolean securitySystem;

        public Builder foundation(String foundation) {
            this.foundation = foundation;
            return this;
        }

        public Builder walls(String walls) {
            this.walls = walls;
            return this;
        }

        public Builder garage(boolean garage) {
            this.garage = garage;
            return this;
        }

        public Builder swimmingPool(boolean swimmingPool) {
            this.swimmingPool = swimmingPool;
            return this;
        }

        public Builder garden(boolean garden) {
            this.garden = garden;
            return this;
        }

        public Builder solarPanels(boolean solarPanels) {
            this.solarPanels = solarPanels;
            return this;
        }

        public Builder securitySystem(boolean securitySystem) {
            this.securitySystem = securitySystem;
            return this;
        }

        public House build() {
            if (this.foundation == null || this.walls == null) {
                throw new IllegalStateException(
                    "Foundation and walls must be set"
                );
            }
            return new House(this);
        }
    }
}

class Main {

    public static void main(String[] args) {
        House house = new House.Builder()
            .foundation("asa")
            .walls("asd")
            .build();

        System.out.println(house);
    }
}
