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
    }
