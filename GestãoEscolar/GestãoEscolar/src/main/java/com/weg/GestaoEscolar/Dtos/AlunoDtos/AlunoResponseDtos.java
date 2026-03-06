package com.weg.GestaoEscolar.Dtos.AlunoDtos;

public record AlunoResponseDtos (

    long id,
    String nome,
    String email,
    int matricula,
    String dataNacimento

){

}
