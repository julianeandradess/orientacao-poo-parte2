package academy.dev.PadroesProjetos.dominio;

public class Pessoa {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;

    //podemos usar o public, porem se vê muito private para forçar o uso do builder
    private Pessoa(String firstName, String lastName, String userName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
    }
    //Padrão builder, ex: em vez de usar void no set, retornamos a propria classe

    @Override
    public String toString() {
        return "Pessoa{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public static final class PessoaBuilder {
        private String firstName;
        private String lastName;
        private String userName;
        private String email;

        public PessoaBuilder() {
        }

        public static PessoaBuilder pessoaB() {
            return new PessoaBuilder();
        }

        public PessoaBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PessoaBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PessoaBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public PessoaBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Pessoa build() {
            return new Pessoa(firstName, lastName, userName, email);
        }
    }
}

