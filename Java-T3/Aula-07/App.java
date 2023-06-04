public class App {
    public static void main(String[] args) throws Exception {
        Person pessoa = new Person("Flávio", "Santana", "15454545478", "Solteiro", "00000000", 'm', 35);
        pessoa.setCpf("11111111111");
        System.out.println(pessoa.toString());
        System.out.println(pessoa.getCep());
    }
}
    class Person{
        private String nome, sobrenome, cpf, relacionamento, cep;
        private char genero;
        private int idade;
        
        @Override
        public String toString() {
            return "Dados: name= " + nome + ", Sobrenome= " + sobrenome + ", cpf= " + cpf + ", relacionamento= " + relacionamento
                    + ", cep= " + cep + ", genero= " + genero + ", idade= " + idade + "";
        }
    
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((nome == null) ? 0 : nome.hashCode());
            result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
            result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
            result = prime * result + ((relacionamento == null) ? 0 : relacionamento.hashCode());
            result = prime * result + ((cep == null) ? 0 : cep.hashCode());
            result = prime * result + genero;
            result = prime * result + idade;
            return result;
        }
    
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Person other = (Person) obj;
            if (nome == null) {
                if (other.nome != null)
                    return false;
            } else if (!nome.equals(other.nome))
                return false;
            if (sobrenome == null) {
                if (other.sobrenome != null)
                    return false;
            } else if (!sobrenome.equals(other.sobrenome))
                return false;
            if (cpf == null) {
                if (other.cpf != null)
                    return false;
            } else if (!cpf.equals(other.cpf))
                return false;
            if (relacionamento == null) {
                if (other.relacionamento != null)
                    return false;
            } else if (!relacionamento.equals(other.relacionamento))
                return false;
            if (cep == null) {
                if (other.cep != null)
                    return false;
            } else if (!cep.equals(other.cep))
                return false;
            if (genero != other.genero)
                return false;
            if (idade != other.idade)
                return false;
            return true;
        }
    
        public Person(String nome, String sobrenome, String cpf, String relacionamento, 
        String cep, char genero, int idade) {
            try{
                this.nome = nome;
                this.sobrenome = sobrenome;
                this.cpf = cpf;
                this.relacionamento = relacionamento;
                this.setCep(cep);
                this.genero = genero;
                this.idade = idade;
            }catch (Exception e){
                throw new IllegalArgumentException("Verifique as info");
            }
    
        }
        
        public String getName() {
            return nome;
        }
        public void setName(String nome) {
            this.nome = nome;
        }
        public String getLastName() {
            return sobrenome;
        }
        public void setLastName(String sobrenome) {
            this.sobrenome = sobrenome;
        }
        public String getCpf() {
            return cpf;
        }
        public void setCpf(String cpf) {
            String cpfChecker = cpf.substring(0,9);
            int multiplierNumber;
            int resultsTotal;
    
             multiplierNumber = 10;
            resultsTotal = 0;
            for (int i = 0; i < cpfChecker.length(); i++) {
                int myDigit = Character.getNumericValue(cpfChecker.charAt(i));
                resultsTotal += myDigit * multiplierNumber;
                multiplierNumber--;
            }

            if(resultsTotal%11 < 2 ){
                cpfChecker = cpfChecker + "0";
            }else{
                cpfChecker = cpfChecker + (11 - resultsTotal%11);
            }

            multiplierNumber = 11;
            resultsTotal = 0;
            for (int i = 0; i < cpfChecker.length(); i++) {
                int myDigit = Character.getNumericValue(cpfChecker.charAt(i));
                resultsTotal += myDigit * multiplierNumber;
                multiplierNumber--;
            }

            if(resultsTotal%11 < 2 ){
                cpfChecker = cpfChecker + "0";
            }else{
                cpfChecker = cpfChecker + (11 - resultsTotal%11);
            }
            if(!(cpf.equals(cpfChecker))){
                throw new IllegalArgumentException("CPF invalido");
            }
    
            this.cpf = cpf;
        }
        public String getMaritalStatus() {
            return relacionamento;
        }
        public void setMaritalStatus(String relacionamento) {
            this.relacionamento = relacionamento;
        }
        /**
         * @deprecated
         * Retorna o cep da pessoa
         * @return o cep da pessoa
         * @see String
         */
        public String getCep() {
            return cep;
        }
        public void setCep(String cep) {
            if(cep == null){
                throw new IllegalArgumentException("CEP Invalido: CEP não pode ser nulo");
            }
            
            int cepSize = cep.length();
    
            if(cepSize != 8){
                throw new IllegalArgumentException("CEP Invalido: CEP Incompleto");
            }
    
            for (int i = 0; i < cepSize; i++) {
                char myChar = cep.charAt(i);
                if(!(myChar >= 48 && myChar <= 57)){
                    throw new IllegalArgumentException("CEP Invalido: CEP somente deve conter numeros");
                }
            }
    
            this.cep = cep;
        }
        public char getGender() {
            return genero;
        }
        public void setGender(char genero) {
            this.genero = genero;
        }
        public int getAge() {
            return idade;
        }
        public void setAge(int idade) {
            this.idade = idade;
        }
}


