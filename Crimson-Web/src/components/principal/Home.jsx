import React from 'react';

import API from '../../service/api';

import Cartelera from './Cartelera';

export default class Home extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      cartelera: [],
    };
  }

  componentDidMount() {
    API.get('/cartelera')
      .then(response => this.cargarCartelera(response));
    // .catch(this.falsificarCartelera());
  }

  cargarCartelera(data) {
    this.setState({ cartelera: data });
  }

  falsificarCartelera() {
    const falsos = [
      {
        nombre: 'Aladdin',
        genero: 'Aventura Romantica',
        clasificacion: 'ATP',
        sinopsis: 'Pasan cosas',
        imagen: 'https://media.kitag.com/filer_public_thumbnails/cinepool/assets/movies/1012.351/artworks/bad5a957cacaa4b7749fc5003ea9aa2bc6eae21b/lrg.png__650x935_q70.jpg',
      },
    ];
    this.setState({ cartelera: falsos });
  }

  probar() {
    console.log(this.state.cartelera);
  }

  render() {
    return (
      <div>
        <h1>Crimson</h1>
        <button type="button" onClick={() => this.probar()}>Probar algo</button>
        <h2>Cartelera</h2>
        <Cartelera contenido={this.state.cartelera} username={undefined} />
      </div>
    );
  }
}
