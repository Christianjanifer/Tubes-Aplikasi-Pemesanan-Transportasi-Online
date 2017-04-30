// Nama     : Gabe Dimas Wicaksana
// NIM      : 1301154245
// Kelas    : IF 39-07
//
// OBJECT ORIENTED PROGRAMMING FINAL PROJECT - TELKOM UNIVERSITY 2017
//
package Model;

import java.util.*;
import java.util.stream.Collectors;

public class Aplikasi {

    private List<Pelanggan> daftarPelanggan;
    private List<Pengemudi> daftarPengemudi;
    private String IdLog;
    private String IdLogDriver;

    public Aplikasi() {
        daftarPelanggan = new ArrayList();
        daftarPengemudi = new ArrayList();
    }

    //PELANGGAN------------------------------------------------------------------------------------------------------------------
    public void addPelanggan(String email, String nama, String noTelp, String password, String username) {
        daftarPelanggan.add(new Pelanggan(email, nama, noTelp, password, username));
    }

    public boolean createPesanan(String lokasiAwal, String destinasi) {

        for (Pelanggan c : daftarPelanggan) {
            if (c.getIdCustomer().equals(IdLog)) {
                c.createPesanan(lokasiAwal, destinasi);
                System.out.println(IdLog);
                return true;
            }
        }
        return false;
    }

    public boolean removePesanan(String idPesanan) {
        for (Pelanggan c : daftarPelanggan) {
            if (c.getIdCustomer().equals(IdLog)) {
                c.removePesanan(idPesanan);
                System.out.println(IdLog);
                return true;
            }
        }
        return false;
    }
    
    public Pelanggan getPelanggan(String id) {
        return daftarPelanggan.stream().filter(c -> c.getIdCustomer().equals(id)).findFirst().orElse(null);
    }

    public Pelanggan getPelanggan(int idx) {
        Pelanggan c = daftarPelanggan.get(idx);
        return c;
    }

    public boolean loginPelanggan(String username, String password) {
        for (Pelanggan c : daftarPelanggan) {
            if (c.getUsername().equals(username) && c.getPassword().equals(password)) {
                IdLog = c.getIdCustomer();
                System.out.println(IdLog);
                return true;
            }
        }
        return false;
    }

    public void searchPelanggan(String searchPelanggan) {
        for (Pelanggan c : daftarPelanggan) {
            if (c.getIdCustomer().equals(searchPelanggan)) {
                System.out.println(c.getIdCustomer());

            }
        }
    }

    public boolean deletePelanggan(String id) {
        for (Pelanggan c : daftarPelanggan) {
            if (c.getIdCustomer().equals(id)) {
                daftarPelanggan.remove(c);
                return true;
            }
        }
        return false;
    }

        
    public void showAllPesanan() {
        for(Pelanggan c : daftarPelanggan) {
           c.toString();
        }
    }
    
    //PENGEMUDI------------------------------------------------------------------------------------------------------------------
    public void addPengemudi(String nomorKendaraan, String nama, String noTelp, String password, String username) {
        daftarPengemudi.add(new Pengemudi(nomorKendaraan, nama, noTelp, password, username));
    }

    public Pengemudi getPengemudi(String id) {
        return daftarPengemudi.stream().filter(d -> d.getIdDriver().equals(id)).findFirst().orElse(null);
    }

    public Pengemudi getPengemudi(int idx) {
        Pengemudi d = daftarPengemudi.get(idx);
        return d;
    }

    public boolean loginPengemudi(String username, String password) {
        for (Pengemudi d : daftarPengemudi) {
            if (d.getUsername().equals(username) && d.getPassword().equals(password)) {
                IdLogDriver = d.getIdDriver();
                System.out.println(IdLogDriver);
                return true;
            }
        }
        return false;
    }

    public boolean deletePengemudi(String id) {
        for (Pengemudi d : daftarPengemudi) {
            if (d.getIdDriver().equals(id)) {
                daftarPengemudi.remove(d);
                return true;
            }
        }
        return false;
    }

    public List<Pelanggan> getDaftarPelanggan() {
        return daftarPelanggan;
    }

    public List<Pengemudi> getDaftarPengemudi() {
        return daftarPengemudi;
    }

    //Prototype------------------------------------------------------------------------------------------------------------------
    public void viewListConsole(String[] list) {
        Arrays.stream(list).forEach(System.out::println);
    }

    public String[] getListPelanggan() {
        List idCust = daftarPelanggan.stream().map(c -> c.toString()).collect(Collectors.toList());
        return (String[]) idCust.stream().toArray(size -> new String[size]);
    }

    public String[] getListPengemudi() {
        List idDriv = daftarPengemudi.stream().map(d -> d.toString()).collect(Collectors.toList());
        return (String[]) idDriv.stream().toArray(size -> new String[size]);
    }
}
