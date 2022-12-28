package com.garanti.endpoints;

import com.garanti.model.Ders;
import com.garanti.model.Ders_Ogrenci;
import com.garanti.repo.DersRepo;
import com.garanti.repo.Ders_OgrenciRepo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
@Path(value = "ders")
public class DersEndpoints {
    private DersRepo repo;

    public DersEndpoints()
    {
        this.repo = new DersRepo();
    }

    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Ders> getAll()
    {
        // localhost:9090/FirstRestfulService/ogretmen/getAll
        return repo.getAll();
    }


    @GET
    @Path(value = "getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ders getByIdPathParam(@PathParam(value = "id") Integer id)
    {
        // path param yazarsam bütün param 'lar set edilmiş olmak zorunda
        // localhost:9090/FirstRestfulService/ogretmen/getById/1
        return repo.getById(id);
    }

    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Ders ders)
    {
        // localhost:9090/FirstRestfulService/ogretmen/save
        repo.save(ders);
        return "Başarı ile kaydedildi";
    }
}
