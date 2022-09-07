import { Directive, ElementRef, HostListener, Renderer2 } from '@angular/core';

@Directive({
  selector: '[grifaTexto]'
})
export class GrifaTextoDirective {

  // el : ElementRef = new ElementRef();
  // Pessoa pessoa = new Pessoa(); 
  // pessoa : Pessoa = new Pessoa(); 
  // Injeção de Dependência

  @HostListener("mouseover") 
  onMouseOver(){
    console.log("mouse over");
    console.log(this.el.nativeElement.classes)
    //this.el.nativeElement.style.backgroundColor = 'yellow';
    this.renderer.setStyle(this.el.nativeElement,'background-color','yellow');
  }
  @HostListener("mouseout")
  onMouseOut(){
    console.log("mouse out");
    //this.el.nativeElement.style.backgroundColor = 'white';
    this.renderer.setStyle(this.el.nativeElement,'background-color','white');
  }

  constructor(private el : ElementRef, private renderer : Renderer2) {
    
  }

}
