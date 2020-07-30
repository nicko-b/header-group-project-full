import React, { Component } from 'react';
import '../App.css';
import data from './PictureData'
import CarouselCard from "./CarouselCard";

class ControlledCarousel extends Component {

    constructor(props){
        super(props);
        this.state = {
            properties: data.properties,
            property: data.properties[0]
        }
    }

    nextProperty = () => {
        const newIndex = this.state.property.index+1;
        this.setState({
            property: data.properties[newIndex]
        })
    }

    prevProperty = () => {
        const newIndex = this.state.property.index-1;
        this.setState({
            property: data.properties[newIndex]
        })
    }

    render() {
        const {property} = this.state;
       // console.log(property)
        return (
            <div className="Carousel">

                <button
                    onClick={() => this.nextProperty()}
                    disabled={property.index === data.properties.length-1}
                >Next</button>
                <button
                    onClick={() => this.prevProperty()}
                    disabled={property.index === 0}
                >Prev</button>
                <div className="cards-slider">
                    <div className="cards-slider-wrapper"/>
                     <CarouselCard property={property} />
                </div>
            </div>
        );
    }
}

export default ControlledCarousel;

