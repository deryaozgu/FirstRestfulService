package com.garanti.endpoints;

import com.garanti.model.Ders_Ogrenci;
import com.garanti.model.Konu;
import com.garanti.repo.Ders_OgrenciRepo;
import com.garanti.repo.KonuRepo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
@Path(value = "dersogrenci")
public class DersOgrenciEndpoints {
    private Ders_OgrenciRepo repo;

    public DersOgrenciEndpoints()
    {
        this.repo = new Ders_OgrenciRepo();
    }

    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Ders_Ogrenci> getAll()
    {
        // localhost:9090/FirstRestfulService/ogretmen/getAll
        return repo.getAll();
    }


    @GET
    @Path(value = "getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ders_Ogrenci getByIdPathParam(@PathParam(value = "id") Integer id)
    {
        // path param yazarsam bütün param 'lar set edilmiş olmak zorunda
        // localhost:9090/FirstRestfulService/ogretmen/getById/1
        return repo.getById(id);
    }

    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Ders_Ogrenci ders_ogrenci)
    {
        // localhost:9090/FirstRestfulService/ogretmen/save
        repo.save(ders_ogrenci);
        return "Başarı ile kaydedildi";
    }
}
