package model;

public class Amigo {

   private String nomeCompleto;
   private String apelido;
   private String senha;

   public Amigo() {

   }

   public Amigo(String nomeCompleto, String apelido, String senha) {
      this.nomeCompleto = nomeCompleto;
      this.apelido = apelido;
      this.senha = senha;
   }

   public String getNomeCompleto() {
      return nomeCompleto;
   }

   public void setNomeCompleto(String nomeCompleto) {
      this.nomeCompleto = nomeCompleto;
   }

   public String getApelido() {
      return apelido;
   }

   public void setApelido(String apelido) {
      this.apelido = apelido;
   }

   public String getSenha() {
      return senha;
   }

   public void setSenha(String senha) {
      this.senha = senha;
   }

   public void cadastrarAmigo(Amigo amigo) {

   }
}
