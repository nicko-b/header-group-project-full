import React from 'react';
import PropTypes from 'prop-types';

const CarouselCard = (props) => {
    const {index, picture} = props.property;


    return (
        <div id={`CarouselCard-${index}`} className="CarouselCard">
            <img src={picture} alt={" "} />
        </div>
    )
}

CarouselCard.propTypes = {
    property: PropTypes.object.isRequired
}

export default CarouselCard;