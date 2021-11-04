import { asLiteral } from '@angular/compiler/src/render3/view/util';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'G39EQUIPO5CICLO4';

  logear(usser: string, pss:any){
    const usuario = usser;
    const contrase = pss;
    console.log("usuario: " + usuario)
    console.log("contraseña: " + contrase)
    if( usuario == 'admininicial' && contrase == 'admin123456'){
      alert("Usuarios Logeado")
    }else{
      alert("Datos erroneos")
    }
  }
}

