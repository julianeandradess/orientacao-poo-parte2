package academy.dev.PadroesProjetos.dominio;

public class ReportDto {
    private String aircrafName;
    private Country country;
    private Moeda currency;
    private String personName;


    public static final class ReporDtoBuilder {
        private String aircrafName;
        private Country country;
        private Moeda currency;
        private String personName;

        private ReporDtoBuilder() {
        }

        public static ReporDtoBuilder builder() {
            return new ReporDtoBuilder();
        }

        public ReporDtoBuilder aircrafName(String aircrafName) {
            this.aircrafName = aircrafName;
            return this;
        }

        public ReporDtoBuilder country(Country country) {
            this.country = country;
            return this;
        }

        public ReporDtoBuilder currency(Moeda currency) {
            this.currency = currency;
            return this;
        }

        public ReporDtoBuilder personName(String personName) {
            this.personName = personName;
            return this;
        }

        public ReportDto build() {
            ReportDto reporDto = new ReportDto();
            reporDto.aircrafName = this.aircrafName;
            reporDto.currency = this.currency;
            reporDto.country = this.country;
            reporDto.personName = this.personName;
            return reporDto;
        }
    }

    @Override
    public String toString() {
        return "ReportDto{" +
                "aircrafName='" + aircrafName + '\'' +
                ", country=" + country +
                ", currency=" + currency +
                ", personName='" + personName + '\'' +
                '}';
    }
}
