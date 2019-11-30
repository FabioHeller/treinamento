package com.codenation.treinamento.service.impl;

import com.codenation.treinamento.annotation.Metodos;
import com.codenation.treinamento.controller.AplicacaoController;
import com.codenation.treinamento.entity.Empresa;
import com.codenation.treinamento.entity.Usuario;
import com.codenation.treinamento.execptions.codenationException;
import com.codenation.treinamento.service.AplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class AplicacaoServiceImpl implements AplicationService {

    private static Logger LOG = LoggerFactory.getLogger(AplicacaoController.class);

    private static List<Usuario> usuarioLista = new ArrayList<>();
    private static List<Empresa> empresaLista = new ArrayList<>();

    @Metodos(text = ("Nome do metodo é: "))
    public static void novoUsuario(Long id, String nome, String documento, int idade, String login, String senha, Long idEmpresa, BigDecimal salario) {
        boolean insere = true;
        if (!nome.equals("") && !documento.equals("") && !login.equals("") && !senha.equals("")) {
            validaExistenciaNome(nome);
            validaExistenciaLogin(login);
            validaExistenciaDocumento(documento);
            insereNovoUsuario(id, nome, documento, idade, login, senha, idEmpresa, salario);
        } else {
            throw new codenationException("\"#### ERROR faltou parametro obrigatorio de usuario!");
        }
    }

    @Metodos(text = ("insereNovoUsuario"))
    private static void insereNovoUsuario(Long id, String nome, String documento, int idade, String login, String senha, Long idEmpresa, BigDecimal salario) {
        //if (insere){
        usuarioLista.add(new Usuario(id, nome, documento, idade, login, senha, idEmpresa, salario));
        LOG.info("#### Inclusão da usuario " + nome + " feito com sucesso!");
        //}
    }

    @Metodos(text = ("validaExistenciaDocumento"))
    private static boolean validaExistenciaDocumento(String documento) {
        if (usuarioLista.stream().anyMatch(usuario -> usuario.getDocumento().equals(documento))) {
            throw new codenationException("#### ERROR Já existe usuario com documento - " + documento);
        }
        return true;
    }
    private static boolean validaExistenciaLogin(String login) {
        if (usuarioLista.stream().anyMatch(usuario -> usuario.getLogin().equals(login))) {
            throw new codenationException("#### ERROR Já existe usuario com login - " + login);
        }
        return true;
    }
    private static boolean validaExistenciaNome(String nome) {
        if (usuarioLista.stream().anyMatch(usuario -> usuario.getNome().equals(nome))) {
            throw new codenationException("#### ERROR Já existe usuario com nome - " + nome);
        }
        return true;
    }
    @Metodos(text = ("Nome do metodo é: "))
    public static void novaEmpresa(Long id, String nome, String documento, int vagas, String site) {
        boolean insere = true;
        if (empresaLista.stream().anyMatch(empresa -> empresa.getDocumento().equals(documento))) {
            insere = false;
            throw new codenationException("#### ERROR Já existe empresa com documento - " + documento);
        }
        if (empresaLista.stream().anyMatch(empresa -> empresa.getId().equals(id))) {
            insere = false;
            throw new codenationException("#### ERROR Já existe empresa com este ID - " + id);
        }
        if (insere) {
            empresaLista.add(new Empresa(id, nome, documento, vagas, site));
            LOG.info("#### Inclusão da empresa {} feita com sucesso!", nome);
        }
    }
    @Metodos(text = ("Nome do metodo é: "))
    public static Empresa findEmpresaByNameE(String nomeEmpresa) {
        return empresaLista.stream().filter(empresa -> empresa.getNome().equals(nomeEmpresa)).findFirst().orElse(null);
    }

    @Metodos(text = ("Nome do metodo é: "))
    public static Empresa findEmpresaById(Long idEmpresa) {
        return empresaLista.stream().filter(empresa -> empresa.getId().equals(idEmpresa)).findFirst().orElse(null);
    }

    public static Usuario findUsuarioByNameE(String nomeUsuario) {
        return usuarioLista.stream().filter(usuario -> usuario.getNome().equals(nomeUsuario)).findFirst().orElse(null);
    }

    public static void findUsuarios(Long id, String nomeUsuario, String documentoUsuario, int idadeUsuario) {
        Empresa empr = findEmpresaById(id);
        Usuario usur = findUsuarioByNameE(nomeUsuario);
        if (id == null && nomeUsuario != null) {
            for (Usuario usr : usuarioLista) {
                empr = findEmpresaById(usr.getIdEmpresa());
                LOG.info("Usuário: " + usr.getNome() + "Empresa: " + empr.getNome());
            }
        }
    }

    public static void vinculaUsuarioEmpresa(String nomeUsuario, String nomeEmpresa) {
        Empresa empr = findEmpresaByNameE(nomeEmpresa);
        Usuario usur = findUsuarioByNameE(nomeUsuario);
        if (empr != null) {
            if (usuarioLista.stream().filter(usuario -> usuario.getIdEmpresa().equals(empr.getId())).count() < empr.getVagas()) {
                if (usur != null) {
                    usur.setIdEmpresa(empr.getId());
                    LOG.info("Usuario: " + usur.getNome() + " inserido na empresa: " + empr.getNome());
                }
            } else {
                throw new codenationException("#### ERROR Empresa " + nomeEmpresa + " não possui vagas no momento!");
            }
        } else {
            throw new codenationException("#### ERROR Empresa " + nomeEmpresa + " não localizada");
        }
    }

    public static List<Usuario> carregarArquivoUsuario(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            Long idUsuario = 1L;
            String array[] = new String[7];
            String linha = br.readLine();
            while (br.ready()) {
                linha = br.readLine();
                array = linha.split(";");
                novoUsuario(
                        idUsuario++, array[0], array[1], Integer.parseInt(array[2]), array[3],
                        array[3].replace("u", "#0P").replace("s", "[%0").replace("e", "lD7").replace("r", "çA="), Long.parseLong(array[5]), new BigDecimal(array[6]));
            }
            //usuarioLista.stream().forEach(usuario -> System.out.println(imprmiListaUsuario(usuario)));
            br.close();
        } catch (FileNotFoundException e) {
            throw new codenationException("#### ERROR Arquivo no caminho " + path + " não localizado!");
        } catch (IOException e) {
            e.printStackTrace();
            throw new codenationException("#### ERROR Falha na leitura do arquivo " + path + "!");
        }
        return usuarioLista;
    }

    private static String imprmiListaUsuario(Usuario usuario) {
        return usuario.getId() + ";\t" + usuario.getNome() + ";\t" + usuario.getDocumento() + ";\t" + usuario.getIdade() + ";\t" + usuario.getLogin() + ";\t" + usuario.getSenha() + ";\t" + usuario.getIdEmpresa() + ";\t" + usuario.getSalario();
    }

    private static String imprmiListaEmpresa(Empresa empresa) {
        return empresa.getId() + ";\t" + empresa.getNome() + ";\t" + empresa.getDocumento() + ";\t" + empresa.getVagas() + ";\t" + empresa.getSite();
    }


    public static List<Empresa> carregarArquivoEmpresa(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            Long idEmpresa = 1L;
            String array[] = new String[4];
            String linha = br.readLine();
            while (br.ready()) {
                linha = br.readLine();
                array = linha.split(";");
                novaEmpresa(idEmpresa++, array[0], array[1], Integer.parseInt(array[2]), array[3]);
            }
            br.close();

            //empresaLista.stream().forEach(empresa -> System.out.println(imprmiListaEmpresa(empresa)));
        } catch (FileNotFoundException e) {
            throw new codenationException("#### ERROR Arquivo no caminho " + path + " não localizado!");
        } catch (IOException e) {
            e.printStackTrace();
            throw new codenationException("#### ERROR Falha na leitura do arquivo " + path + "!");
        }
        return empresaLista;
    }

    public static void maiorSalarioCadaEmpresa() {
        List<Empresa> empresas = new ArrayList<Empresa>(empresaLista);
        List<Usuario> usuarios = new ArrayList<Usuario>(usuarioLista);
        BigDecimal maiorSalario = new BigDecimal(0.0);
        empresas.sort(Comparator.comparingLong(Empresa::getId));
        usuarios.sort(Comparator.comparingLong(Usuario::getIdEmpresa));
        for (Empresa emp : empresas) {
            for (Usuario usu : usuarios) {
                if (usu.getIdEmpresa() == emp.getId()) {
                    if (usu.getSalario().compareTo(maiorSalario) == 1) {
                        maiorSalario = usu.getSalario();
                    }
                }
            }
            LOG.info("#### {} maior salário é:  {} ", emp.getNome(), maiorSalario);
            //System.out.println(emp.getNome() + " maior salário é: " + maiorSalario);
            maiorSalario = new BigDecimal(0.0);
        }
    }

    public static BigDecimal maiorSalarioGeral() {
        List<Usuario> usuarios = new ArrayList<Usuario>(usuarioLista);
        BigDecimal maiorSalario = new BigDecimal(0.0);
        for (Usuario usu : usuarios) {
            if (usu.getSalario().compareTo(maiorSalario) == 1) {
                maiorSalario = usu.getSalario();
            }
        }
        LOG.info("#### Maior salário geral é:  {} ", maiorSalario);
        return maiorSalario;
    }

    public static void mediaSalarialCadaEmpresa() {
        List<Empresa> empresas = new ArrayList<Empresa>(empresaLista);
        List<Usuario> usuarios = new ArrayList<Usuario>(usuarioLista);
        BigDecimal maiorSalario = new BigDecimal(0.0);
        Long idEmp;
        Integer count = 0;
        empresas.sort(Comparator.comparingLong(Empresa::getId));
        usuarios.sort(Comparator.comparingLong(Usuario::getIdEmpresa));
        for (Empresa emp : empresas) {
            for (Usuario usu : usuarios) {
                if (usu.getIdEmpresa() == emp.getId()) {
                    maiorSalario = usu.getSalario().add(maiorSalario);
                    count++;
                }
            }
            LOG.info("#### {} média salarial é:  {} ", emp.getNome(), maiorSalario.longValue() / count);
            //System.out.println(emp.getNome() + " média salarial é: " + maiorSalario.longValue() / count);
            maiorSalario = new BigDecimal(0.0);
            count = 0;
        }
    }

    public static void folhaTotalEmpresa() {
        List<Empresa> empresas = new ArrayList<Empresa>(empresaLista);
        List<Usuario> usuarios = new ArrayList<Usuario>(usuarioLista);
        BigDecimal totalSalario = new BigDecimal(0.0);
        empresas.sort(Comparator.comparingLong(Empresa::getId));
        usuarios.sort(Comparator.comparingLong(Usuario::getIdEmpresa));
        for (Empresa emp : empresas) {
            for (Usuario usu : usuarios) {
                if (usu.getIdEmpresa() == emp.getId()) {
                    totalSalario = usu.getSalario().add(totalSalario);
                }
            }
            LOG.info("#### {} folha total é:  {} ", emp.getNome(), totalSalario);
            //System.out.println(emp.getNome() + " folha total é: " + totalSalario);
            totalSalario = new BigDecimal(0.0);
        }
    }

    public static void empresaMenorCusto() {
        List<Usuario> usuarios = new ArrayList<Usuario>(usuarioLista);
        List<Empresa> empresas = new ArrayList<Empresa>(empresaLista);
        BigDecimal totalSalario = new BigDecimal(0.0);
        BigDecimal menorSalarioE = new BigDecimal(0.0);
        String nomempresa = null;
        for (Usuario usu : usuarios) {
            menorSalarioE = usu.getSalario().add(menorSalarioE);
        }
        empresas.sort(Comparator.comparingLong(Empresa::getId));
        usuarios.sort(Comparator.comparingLong(Usuario::getIdEmpresa));
        for (Empresa emp : empresas) {
            for (Usuario usu : usuarios) {
                if (usu.getIdEmpresa() == emp.getId()) {
                    totalSalario = usu.getSalario().add(totalSalario);
                }
            }
            if(totalSalario.compareTo(menorSalarioE) < 0){
                menorSalarioE = new BigDecimal(totalSalario.longValue());
                nomempresa = emp.getNome();
            }
            totalSalario = new BigDecimal(0.0);
        }

        LOG.info("#### {} folha total é:  {} ", nomempresa, menorSalarioE);
        //System.out.println(nomempresa + " possui o menor custo: " + menorSalarioE);

    }

    public static void mediaIdade() {
        List<Empresa> empresas = new ArrayList<Empresa>(empresaLista);
        List<Usuario> usuarios = new ArrayList<Usuario>(usuarioLista);
        Integer idade = 0;
        Long idEmp;
        Integer count = 0;
        empresas.sort(Comparator.comparingLong(Empresa::getId));
        usuarios.sort(Comparator.comparingLong(Usuario::getIdEmpresa));
        for (Empresa emp : empresas) {
            for (Usuario usu : usuarios) {
                if (usu.getIdEmpresa() == emp.getId()) {
                    idade = usu.getIdade() + idade;
                    count++;
                }
            }
            //System.out.println(emp.getNome() + " média da idade dos funcionários é: " + idade / count);
            LOG.info("#### {} média da idade dos funcionários é:  {} ", emp.getNome(), idade / count);
            idade = 0;
            count = 0;
        }
    }

    public static void listaOrdenadaPorIdadePorEmpresa() {
        List<Empresa> empresas = new ArrayList<Empresa>(empresaLista);
        List<Usuario> usuarios = new ArrayList<Usuario>(usuarioLista);
        Integer idade = 0;
        Long idEmp;
        Integer count = 0;
        empresas.sort(Comparator.comparingLong(Empresa::getId));
        usuarios.sort(Comparator.comparingLong(Usuario::getIdade));
        for (Empresa emp : empresas) {
            for (Usuario usu : usuarios) {
                if (usu.getIdEmpresa() == emp.getId()) {
                    //System.out.println(emp.getNome() + "; Funcionário - " + usu.getNome() + "; Idade - " + usu.getIdade());
                    LOG.info("#### {} ; Funcionário - {}; Idade - {}", emp.getNome(), usu.getNome(), usu.getIdade());
                }
            }
        }
    }
}
