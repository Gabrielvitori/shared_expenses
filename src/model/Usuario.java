package model;

import java.util.ArrayList;
import java.util.List;

    public class Usuario {
        private String nome;
        private String email;
        private List<Grupo> grupos = new ArrayList<>();

        public Usuario(String nome, String email) {
            this.nome = nome;
            this.email = email;
        }

        public void adicionarGrupo(Grupo grupo) {
            grupos.add(grupo);
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public List<Grupo> getGrupos() {
            return grupos;
        }

        public void setGrupos(List<Grupo> grupos) {
            this.grupos = grupos;
        }


    }
